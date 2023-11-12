package com.api.prontuario;

import com.api.prontuario.entites.User;
import com.api.prontuario.enums.Role;
import com.api.prontuario.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.CharBuffer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DadosIniciaisLoader implements CommandLineRunner {


    private final PasswordEncoder passwordEncoder;



    private final UserRepository userRepository;

    public DadosIniciaisLoader(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        // Verifica se já existem dados no banco, se não, popula com os dados iniciais
        if (userRepository.count() == 0) {
            User user = new User();
            user.setNome("emanuel");
            user.setCpf("123.456.789-00");
            user.setTelefone("(11) 5555-5555");
            user.setRole(Role.ADMIN);
            user.setLogin("emanuel");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//            user.setDataNascimento(LocalDate.parse("07/10/2004", formatter));
            user.setPassword(passwordEncoder.encode(CharBuffer.wrap("Almeida")));

            userRepository.save(user);
        }
    }
}
