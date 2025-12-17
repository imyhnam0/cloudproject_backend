package com.cloudproject.community_backend.config;

import com.cloudproject.community_backend.entity.*;
import com.cloudproject.community_backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Configuration
@RequiredArgsConstructor
public class TestDataLoader {

    private final UserRepository userRepository;
    private final SchoolRepository schoolRepository;
    private final PostRepository postRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    @Profile("!prod")
    public CommandLineRunner loadTestData() {
        return args -> {
            // 이미 데이터가 있으면 초기화 건너뛰기
            if (userRepository.count() > 0) {
                System.out.println("✅ 테스트 데이터가 이미 존재합니다. 초기화를 건너뜁니다.");
                return;
            }

            System.out.println("📝 테스트 데이터 초기화 시작...");

            School testSchool = new School();
            testSchool.setName("서울중학교");
            schoolRepository.save(testSchool);

            User student1 = new User();
            student1.setEmail("student1@test.com");
            student1.setPassword(passwordEncoder.encode("password123"));
            student1.setUsername("학생1");
            student1.setSchool(testSchool);
            student1.setGrade(1);
            student1.setRole(UserRole.STUDENT);
            student1.setIsSeniorVerified(false);
            userRepository.save(student1);

            User student2 = new User();
            student2.setEmail("student2@test.com");
            student2.setPassword(passwordEncoder.encode("password123"));
            student2.setUsername("학생2");
            student2.setSchool(testSchool);
            student2.setGrade(1);
            student2.setRole(UserRole.STUDENT);
            student2.setIsSeniorVerified(false);
            userRepository.save(student2);

            User student3 = new User();
            student3.setEmail("student3@test.com");
            student3.setPassword(passwordEncoder.encode("password123"));
            student3.setUsername("학생3");
            student3.setSchool(testSchool);
            student3.setGrade(2);
            student3.setRole(UserRole.STUDENT);
            student3.setIsSeniorVerified(false);
            userRepository.save(student3);

            User student4 = new User();
            student4.setEmail("student4@test.com");
            student4.setPassword(passwordEncoder.encode("password123"));
            student4.setUsername("학생4");
            student4.setSchool(testSchool);
            student4.setGrade(2);
            student4.setRole(UserRole.STUDENT);
            student4.setIsSeniorVerified(false);
            userRepository.save(student4);

            User student5 = new User();
            student5.setEmail("student5@test.com");
            student5.setPassword(passwordEncoder.encode("password123"));
            student5.setUsername("학생5");
            student5.setSchool(testSchool);
            student5.setGrade(3);
            student5.setRole(UserRole.STUDENT);
            student5.setIsSeniorVerified(false);
            userRepository.save(student5);

            User student6 = new User();
            student6.setEmail("student6@test.com");
            student6.setPassword(passwordEncoder.encode("password123"));
            student6.setUsername("학생6");
            student6.setSchool(testSchool);
            student6.setGrade(3);
            student6.setRole(UserRole.STUDENT);
            student6.setIsSeniorVerified(false);
            userRepository.save(student6);

            User student7 = new User();
            student7.setEmail("student7@test.com");
            student7.setPassword(passwordEncoder.encode("password123"));
            student7.setUsername("학생7");
            student7.setSchool(testSchool);
            student7.setGrade(1);
            student7.setRole(UserRole.STUDENT);
            student7.setIsSeniorVerified(false);
            userRepository.save(student7);

            User student8 = new User();
            student8.setEmail("student8@test.com");
            student8.setPassword(passwordEncoder.encode("password123"));
            student8.setUsername("학생8");
            student8.setSchool(testSchool);
            student8.setGrade(2);
            student8.setRole(UserRole.STUDENT);
            student8.setIsSeniorVerified(false);
            userRepository.save(student8);

            User student9 = new User();
            student9.setEmail("student9@test.com");
            student9.setPassword(passwordEncoder.encode("password123"));
            student9.setUsername("학생9");
            student9.setSchool(testSchool);
            student9.setGrade(3);
            student9.setRole(UserRole.STUDENT);
            student9.setIsSeniorVerified(false);
            userRepository.save(student9);

            User senior1 = new User();
            senior1.setEmail("senior1@test.com");
            senior1.setPassword(passwordEncoder.encode("password123"));
            senior1.setUsername("선배1");
            senior1.setSchool(testSchool);
            senior1.setGrade(2);
            senior1.setRole(UserRole.STUDENT);
            senior1.setIsSeniorVerified(true);
            senior1.setSeniorVerifiedAt(LocalDateTime.now().minusDays(7));
            userRepository.save(senior1);

            User senior2 = new User();
            senior2.setEmail("senior2@test.com");
            senior2.setPassword(passwordEncoder.encode("password123"));
            senior2.setUsername("선배2");
            senior2.setSchool(testSchool);
            senior2.setGrade(3);
            senior2.setRole(UserRole.STUDENT);
            senior2.setIsSeniorVerified(true);
            senior2.setSeniorVerifiedAt(LocalDateTime.now().minusDays(30));
            userRepository.save(senior2);

            User admin = new User();
            admin.setEmail("admin@test.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setUsername("관리자");
            admin.setSchool(testSchool);
            admin.setGrade(null);
            admin.setRole(UserRole.ADMIN);
            admin.setIsSeniorVerified(false);
            userRepository.save(admin);

            Post normalPost = new Post();
            normalPost.setTitle("안녕하세요");
            normalPost.setContent("첫 게시글입니다");
            normalPost.setAuthor(student1);
            normalPost.setBoardType(PostBoardType.TALK);
            normalPost.setBad(false);
            postRepository.save(normalPost);

            Post questionPost = new Post();
            questionPost.setTitle("수학 질문있어요");
            questionPost.setContent("이차방정식 풀이 방법을 모르겠어요");
            questionPost.setAuthor(student1);
            questionPost.setBoardType(PostBoardType.QUESTION);
            questionPost.setBad(false);
            postRepository.save(questionPost);

            Post badPost = new Post();
            badPost.setTitle("테스트");
            badPost.setContent("야이 멍청아");
            badPost.setAuthor(student1);
            badPost.setBoardType(PostBoardType.TALK);
            badPost.setBad(true);
            postRepository.save(badPost);
        };
    }
}
