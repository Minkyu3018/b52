package org.zerock.b52.mappers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.b52.dto.MemberReadDTO;

@SpringBootTest
public class MemberMapperTests {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private PasswordEncoder encoder;


    @Test
	void setTime(){
		System.out.println(memberMapper.getTime());
	}

    @Transactional
    @Commit
    @Test
	void TestInsert(){

        String email = "MINKYU87@naver.com";
        String mpw = encoder.encode("1111");
        String mname = "MINKYU33";

        String rolename = "ADMIN";

        memberMapper.insertMember(email , mpw , mname);
        memberMapper.insertMemberRole(email , rolename);
        memberMapper.insertMemberRole(email , "USER");



		System.out.println(memberMapper.getTime());
	}


    @Test
	public void TestSelectOne(){
    
        String email = "MINKYU87@naver.com";

        MemberReadDTO dto = memberMapper.selectOne(email);

        System.out.println(dto);

    }
}
