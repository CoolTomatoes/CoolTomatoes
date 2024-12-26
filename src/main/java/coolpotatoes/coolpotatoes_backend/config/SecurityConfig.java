package coolpotatoes.coolpotatoes_backend.config;
//
//import coolpotatoes.coolpotatoes_backend.filter.JWTFilter;
//import coolpotatoes.coolpotatoes_backend.filter.LoginFilter;
import coolpotatoes.coolpotatoes_backend.filter.JWTFilter;
import coolpotatoes.coolpotatoes_backend.jwt.JWTUtil;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;
///*새날지기코드*/
////@Configuration
////@EnableWebSecurity
////@RequiredArgsConstructor
////public class SecurityConfig{
////
////    /*
////      Authentication 은 프론트에서 외부 API를 통해 진행
////      서버측에서는 프론트에서 사용자 id, pw, 이름, 학과, 학번, 학생상태 가 넘어오면 JWT access token 발급
////
////      이후 프론트에서 요청이 올 경우 헤더의 JWT를 JWT Filter를 통해 사용자 정보를 확인
////     */
////
////    private final JWTUtil jwtUtil;
////
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////
////        http
////                .csrf(auth -> auth.disable());
////
////        http
////                .formLogin(auth -> auth.disable());
////
////        http
////                .httpBasic(auth -> auth.disable());
////
////        http
////                .cors(auth -> auth.disable());
////
////
////        http
////                .authorizeHttpRequests(auth -> auth
////                        .requestMatchers("/", "/login", "/docs/**",
////                                "/v3/api-docs/**", "/swagger-ui/**", "/ws-stomp/**").permitAll()
////                        .anyRequest().authenticated());
////
////
////        // 필터 등록
////        http
////                .addFilterBefore(new JWTFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);
////
////
////        http
////                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
////
////        return http.build();
////    }
////
////
////}
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final AuthenticationConfiguration authenticationConfiguration;
//    private final JWTUtil jwtUtil;
//
//    public SecurityConfig(AuthenticationConfiguration authenticationConfiguration, JWTUtil jwtUtil) {
//
//        this.authenticationConfiguration = authenticationConfiguration;
//        this.jwtUtil = jwtUtil;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
//
//        return configuration.getAuthenticationManager();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        //csrf disable
//        http
//                .csrf((auth) -> auth.disable());
//
//
//        http
//                .cors(auth -> auth.disable());
//
//
//        http
//                .authorizeHttpRequests((auth) -> auth
//
//                        .requestMatchers("/", "/login", "/docs/**", "/swagger-ui.html",
//                                "/v3/api-docs/**", "/swagger-ui/**", "/ws-stomp/**").permitAll()
//                        .requestMatchers("/admin").hasRole("ADMIN")
//                        .anyRequest().authenticated());
//
//
//        //세션 설정
//        http
//                .sessionManagement((session) -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//        return http.build();
//    }
//}

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig{

    /*
      Authentication 은 프론트에서 외부 API를 통해 진행
      서버측에서는 프론트에서 사용자 id, pw, 이름, 학과, 학번, 학생상태 가 넘어오면 JWT access token 발급

      이후 프론트에서 요청이 올 경우 헤더의 JWT를 JWT Filter를 통해 사용자 정보를 확인
     */

    private final JWTUtil jwtUtil;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(auth -> auth.disable());

        http
                .formLogin(auth -> auth.disable());

        http
                .httpBasic(auth -> auth.disable());

        http
                .cors(auth -> auth.disable());

        /* 우선은 모든 경로에 인증X -> 추후 수정 예정 */
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/users/login", "/users/login/**", "/docs/**",
                                "/v3/api-docs/**", "/swagger-ui/**", "/ws-stomp/**").permitAll()
                        .requestMatchers("/admin", "/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated());

//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/**").permitAll());

        // 필터 등록
        http
                .addFilterBefore(new JWTFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);


        http
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }


}