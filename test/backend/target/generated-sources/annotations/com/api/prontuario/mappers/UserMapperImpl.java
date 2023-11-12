package com.api.prontuario.mappers;

import com.api.prontuario.dtos.ConsultaDto;
import com.api.prontuario.dtos.EnderecoDto;
import com.api.prontuario.dtos.ExameDto;
import com.api.prontuario.dtos.FichaCadastralDto;
import com.api.prontuario.dtos.HistoricoDto;
import com.api.prontuario.dtos.MedicamentoDto;
import com.api.prontuario.dtos.MedicoDto;
import com.api.prontuario.dtos.PacienteDto;
import com.api.prontuario.dtos.ProcedimentoDto;
import com.api.prontuario.dtos.RegistroMedicoDto;
import com.api.prontuario.dtos.SignUpUserDto;
import com.api.prontuario.dtos.SingUpMedicoDto;
import com.api.prontuario.dtos.UserDto;
import com.api.prontuario.entites.Endereco;
import com.api.prontuario.entites.FichaCadastral;
import com.api.prontuario.entites.Medico;
import com.api.prontuario.entites.Paciente;
import com.api.prontuario.entites.RegistroMedico;
import com.api.prontuario.entites.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-12T17:58:02-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto.UserDtoBuilder<?, ?> userDto = UserDto.builder();

        userDto.id( user.getId() );
        userDto.cpf( user.getCpf() );
        userDto.nome( user.getNome() );
        userDto.dataNascimento( user.getDataNascimento() );
        userDto.telefone( user.getTelefone() );
        userDto.role( user.getRole() );
        userDto.login( user.getLogin() );

        return userDto.build();
    }

    @Override
    public MedicoDto toMedicoDto(Medico medico) {
        if ( medico == null ) {
            return null;
        }

        MedicoDto.MedicoDtoBuilder<?, ?> medicoDto = MedicoDto.builder();

        medicoDto.id( medico.getId() );
        medicoDto.cpf( medico.getCpf() );
        medicoDto.nome( medico.getNome() );
        medicoDto.dataNascimento( medico.getDataNascimento() );
        medicoDto.telefone( medico.getTelefone() );
        medicoDto.role( medico.getRole() );
        medicoDto.login( medico.getLogin() );
        medicoDto.crm( medico.getCrm() );
        medicoDto.especialidade( medico.getEspecialidade() );

        return medicoDto.build();
    }

    @Override
    public FichaCadastralDto toFichaCadastralDto(FichaCadastral fichaCadastral) {
        if ( fichaCadastral == null ) {
            return null;
        }

        String temperatura = null;
        String anamnese = null;
        String queixa = null;
        String exameFisico = null;
        String dor = null;
        String saturacao = null;
        String glicemiaCapilar = null;
        List<String> comorbidades = null;

        temperatura = fichaCadastral.getTemperatura();
        anamnese = fichaCadastral.getAnamnese();
        queixa = fichaCadastral.getQueixa();
        exameFisico = fichaCadastral.getExameFisico();
        dor = fichaCadastral.getDor();
        saturacao = fichaCadastral.getSaturacao();
        glicemiaCapilar = fichaCadastral.getGlicemiaCapilar();
        List<String> list = fichaCadastral.getComorbidades();
        if ( list != null ) {
            comorbidades = new ArrayList<String>( list );
        }

        List<String> alergias = null;
        boolean isExterno = false;
        String med = null;
        String medEmUso = null;
        String pressao = null;
        String freqRespiratoria = null;
        String freqCardiaca = null;

        FichaCadastralDto fichaCadastralDto = new FichaCadastralDto( alergias, isExterno, temperatura, anamnese, queixa, med, medEmUso, exameFisico, pressao, freqRespiratoria, freqCardiaca, dor, saturacao, glicemiaCapilar, comorbidades );

        return fichaCadastralDto;
    }

    @Override
    public RegistroMedicoDto toRegistroMedicoDto(RegistroMedico registroMedico) {
        if ( registroMedico == null ) {
            return null;
        }

        MedicamentoDto medicamentoDto = null;
        ConsultaDto consultaDto = null;
        ExameDto exameDto = null;
        ProcedimentoDto procedimentoDto = null;
        HistoricoDto historicoDto = null;

        RegistroMedicoDto registroMedicoDto = new RegistroMedicoDto( medicamentoDto, consultaDto, exameDto, procedimentoDto, historicoDto );

        return registroMedicoDto;
    }

    @Override
    public EnderecoDto toEnderecoDto(Endereco endereco) {
        if ( endereco == null ) {
            return null;
        }

        String cep = null;
        String complemento = null;
        String logradouro = null;
        String numero = null;
        String bairro = null;
        String cidade = null;
        String estado = null;
        String pais = null;

        cep = endereco.getCep();
        complemento = endereco.getComplemento();
        logradouro = endereco.getLogradouro();
        numero = endereco.getNumero();
        bairro = endereco.getBairro();
        cidade = endereco.getCidade();
        estado = endereco.getEstado();
        pais = endereco.getPais();

        EnderecoDto enderecoDto = new EnderecoDto( cep, complemento, logradouro, numero, bairro, cidade, estado, pais );

        return enderecoDto;
    }

    @Override
    public PacienteDto toPacienteDto(Paciente paciente) {
        if ( paciente == null ) {
            return null;
        }

        String nome = null;
        String cpf = null;
        String telefone = null;
        String curso = null;

        nome = paciente.getNome();
        cpf = paciente.getCpf();
        telefone = paciente.getTelefone();
        curso = paciente.getCurso();

        FichaCadastralDto fichaCadastralDto = null;
        Date dataNasc = null;
        EnderecoDto enderecoDto = null;
        String raca = null;
        Double peso = null;
        Integer altura = null;
        String email = null;
        RegistroMedicoDto registroMedicoDto = null;

        PacienteDto pacienteDto = new PacienteDto( fichaCadastralDto, nome, cpf, dataNasc, enderecoDto, telefone, raca, peso, curso, altura, email, registroMedicoDto );

        return pacienteDto;
    }

    @Override
    public User signUpToUser(SignUpUserDto signUpUserDto) {
        if ( signUpUserDto == null ) {
            return null;
        }

        User user = new User();

        user.setCpf( signUpUserDto.cpf() );
        user.setNome( signUpUserDto.nome() );
        user.setTelefone( signUpUserDto.telefone() );
        user.setLogin( signUpUserDto.login() );

        return user;
    }

    @Override
    public Medico signUpToMedico(SingUpMedicoDto singUpMedicoDto) {
        if ( singUpMedicoDto == null ) {
            return null;
        }

        Medico medico = new Medico();

        medico.setCpf( singUpMedicoDto.cpf() );
        medico.setNome( singUpMedicoDto.nome() );
        medico.setTelefone( singUpMedicoDto.telefone() );
        medico.setLogin( singUpMedicoDto.login() );
        medico.setPassword( singUpMedicoDto.password() );

        return medico;
    }
}
