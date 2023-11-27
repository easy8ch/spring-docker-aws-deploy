package com.goorm.tricountapi.repository;

import com.goorm.tricountapi.model.Member;
import com.goorm.tricountapi.model.Settlement;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class SettlementRepositoryImpl implements SettlementRepository{
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Settlement create(String name) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("settlement").usingGeneratedKeyColumns("id");

        Map<String, Object> parmas = new HashMap<>();
        parmas.put("name", name);

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parmas));

        Settlement settlement = new Settlement();
        settlement.setId(key.longValue());
        settlement.setName(name);

        return settlement;
    }

    @Override
    public void addParticipantToSettlement(Long settlementId, Long memberId) {
        jdbcTemplate.update("INSERT INTO settlement_participant (settlement_id, member_id) VALUES (?, ?)",
                settlementId, memberId);
    }

    @Override
    public Optional<Settlement> findById(Long id) {
        List<Settlement> result = jdbcTemplate.query("select * from settlement "
                + "join settlement_participant on settlement.id = settlement_participant.settlement_id "
                + "join member on settlement_participant.member_id = member.id "
                + "where settlement.id = ?", settlementParticipantsRowMapper(), id);
        return result.stream().findAny();
    }

    private RowMapper<Settlement> settlementParticipantsRowMapper() {
        return ((rs, rowNum) -> {
            Settlement settlement = new Settlement();
            settlement.setId(rs.getLong("settlement.id"));
            settlement.setName(rs.getString("settlement.name"));

            // List 만들기
            List<Member> participants = new ArrayList<>();
            do {
                Member participant = new Member(
                   rs.getLong("member.id"),
                    rs.getString("member.login_id"),
                    rs.getString("member.name"),
                    rs.getString("member.password")
                );
                participants.add(participant);
            } while(rs.next());

            settlement.setParticipants(participants);
            return settlement;
        });
    }
}
