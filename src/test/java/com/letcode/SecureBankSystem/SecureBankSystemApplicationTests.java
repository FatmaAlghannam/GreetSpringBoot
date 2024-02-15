package com.letcode.SecureBankSystem;

import com.letcode.SecureBankSystem.entity.SuggestionEntity.GuestSuggestionEntity;
import com.letcode.SecureBankSystem.entity.UserEntity;
import com.letcode.SecureBankSystem.repository.SuggestionRepository.GuestSuggestionRepository;
import com.letcode.SecureBankSystem.repository.UserRepository;
import com.letcode.SecureBankSystem.service.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class SecureBankSystemApplicationTests {
    //we can delete it>
    @Test
    void contextLoads() {
    }

    //i bring the mock(COPY) one not the original- from the repository - not on the database on my code
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void whenUsersPasswordIsLargerThan8Digit_ThenSuccess() {
        //Arrange
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setName("Fatma");
        userEntity1.setPassword("12345678");


        UserEntity userEntity2 = new UserEntity();
        userEntity2.setName("Nada");
        userEntity2.setPassword("123456789");

        UserEntity userEntity3 = new UserEntity();
        userEntity3.setName("Razan");
        userEntity3.setPassword("123");

        //not a real data its only get all users and test them if they are working:Mockito
        List<UserEntity> moksUserEntities = Arrays.asList(userEntity1, userEntity2, userEntity3);
        when(userRepository.findAll()).thenReturn(moksUserEntities);

        //Act
        List<String> userWithStrongPassword = userService.getAllUserWithStrongPassword();

        //Assert:
        List<String> expectedUserWithStrongPassword = Arrays.asList("Nada");
        assertEquals(expectedUserWithStrongPassword, userWithStrongPassword);

    }


    @Test
    public void whenGetCreateStatus_thenSuccess() {
        //Arrange
        GuestSuggestionEntity suggestionEntity = new GuestSuggestionEntity();
      //  when(GuestSuggestionRepository.getSuggestions()).thenReturn() {

        }

        @Test
       public void whenGetRemoveStatus_thenSuccess() {
            //Arrange
           // when(GuestSuggestionRepository.getSuggestions()).thenReturn() {

            }
        }


















//user entity
//                int sum = 5+5;
//        Assertions.assertSame(20,sum);


//    @Test
//    public  void justText(){
//
//    }
