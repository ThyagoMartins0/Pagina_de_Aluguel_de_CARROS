package com.ecommerce.carro.loja.de.carro.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import javax.validation.*;
import javax.xml.validation.Validator;
import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserModelTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        // Configura o Validator para verificar as anotações de validação
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = (Validator) factory.getValidator();
    }

    @Test
    public void deveCriarUsuarioComDadosValidos() {
        // Arrange
        UserModel user = new UserModel("João","Silva", "joao.silva@example.com", "senha123");

        // Act
        Set<ConstraintViolation<UserModel>> violations = validator.validate(user);

        // Assert
        assertTrue(violations.isEmpty(), "Usuário com dados válidos não deve ter violações");
    }

    @Test
    public void naoDevePermitirEmailInvalido() {
        // Arrange
        UserModel user = new UserModel("Maria","Souza", "email-invalido", "senha123");

        // Act
        Set<ConstraintViolation<UserModel>> violations = validator.validate(user);

        // Assert
        assertFalse(violations.isEmpty(), "Email inválido deve gerar violação");
        assertThat(violations)
                .extracting(ConstraintViolation::getPropertyPath)
                .containsExactlyInAnyOrder("email");
    }

    @Test
    public void naoDevePermitirNomeNulo() {
        // Arrange
        UserModel user = new UserModel(null,null, "maria.souza@example.com", "senha123");

        // Act
        Set<ConstraintViolation<UserModel>> violations = validator.validate(user);

        // Assert
        assertFalse(violations.isEmpty(), "Nome nulo deve gerar violação");
        assertThat(violations)
                .extracting(ConstraintViolation::getPropertyPath)
                .containsExactlyInAnyOrder("nome");
    }

    @Test
    public void equalsDeveConsiderarId() {
        // Arrange
        UserModel user1 = new UserModel("Carlos"," Pereira", "carlos.pereira@example.com", "senha123");
        user1.setId(1L);

        UserModel user2 = new UserModel("Carlos"," Pereira", "carlos.pereira@example.com", "senha123");
        user2.setId(1L);

        UserModel user3 = new UserModel("Ana"," Lima", "ana.lima@example.com", "senha456");
        user3.setId(2L);

        // Act & Assert
        assertEquals(user1, user2, "Usuários com mesmo ID devem ser iguais");
        assertNotEquals(user1, user3, "Usuários com IDs diferentes não devem ser iguais");
    }

    @Test
    public void hashCodeDeveSerConsistenteComEquals() {
        // Arrange
        UserModel user1 = new UserModel("Carlos Pereira", "carlos.pereira@example.com", "senha123");
        user1.setId(1L);

        UserModel user2 = new UserModel("Carlos Pereira", "carlos.pereira@example.com", "senha123");
        user2.setId(1L);

        // Act & Assert
        assertEquals(user1.hashCode(), user2.hashCode(), "HashCodes devem ser iguais para objetos iguais");
    }

    @Test
    public void toStringDeveConterCamposImportantes() {
        // Arrange
        UserModel user = new UserModel("Laura Mendes", "laura.mendes@example.com", "senha123");
        user.setId(3L);

        // Act
        String toString = user.toString();

        // Assert
        assertThat(toString).contains("id=3", "nome='Laura Mendes'", "email='laura.mendes@example.com'");
        assertThat(toString).doesNotContain("senha");
    }
}
