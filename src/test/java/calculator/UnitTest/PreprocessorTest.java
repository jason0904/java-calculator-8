package calculator.UnitTest;

import org.junit.jupiter.api.Test;

import calculator.Model.NumberRepository;
import calculator.Model.Preprocessor;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PreprocessorTest {

    //커스텀 문자열 인식하는지
    @Test
    @DisplayName("커스텀 구분자 연산 테스트")
    public void customDelimiterCalculateTest() {
        NumberRepository numberRepository = new NumberRepository();
        Preprocessor preprocessor = new Preprocessor(numberRepository);
        preprocessor.Preprocessing("//;\\n1");
        assertEquals(1, numberRepository.getNumbers().size());
        assertEquals(1, numberRepository.getNumbers().get(0));        
    }

    //연산자 두번쓰이는 경우
    @Test
    @DisplayName("연산자 두번 쓰이는 경우 테스트")
    public void doubleOperatorTest() {
        NumberRepository numberRepository = new NumberRepository();
        Preprocessor preprocessor = new Preprocessor(numberRepository);
        assertThrows(IllegalArgumentException.class, () -> {preprocessor.Preprocessing("1,,2");});
    }


    //첫 문자 연산자인 경우
    @Test
    @DisplayName("첫 문자가 연산자일 경우 테스트")
    public void firstCharIsOperatorTest() {
        NumberRepository numberRepository = new NumberRepository();
        Preprocessor preprocessor = new Preprocessor(numberRepository);
        assertThrows(IllegalArgumentException.class, () -> {preprocessor.Preprocessing(",2");});
    }

    //마지막 문자 연산자인 경우
    @Test
    @DisplayName("마지막 문자가 연산자일 경우 테스트")
    public void lastCharIsOperatorTest() {
        NumberRepository numberRepository = new NumberRepository();
        Preprocessor preprocessor = new Preprocessor(numberRepository);
        assertThrows(IllegalArgumentException.class, () -> {preprocessor.Preprocessing("2,");});
    }    

    //공백 문자열 에러 체크
    @Test
    @DisplayName("마지막 문자가 연산자일 경우 테스트")
    public void blankStringTest() {
        NumberRepository numberRepository = new NumberRepository();
        Preprocessor preprocessor = new Preprocessor(numberRepository);
        assertThrows(IllegalArgumentException.class, () -> {preprocessor.Preprocessing("");});
    }
    
    //입력값 공백 무시체크
    @Test
    @DisplayName("입력값 공백 무시 테스트")
    public void ignoreBlankTest() {
        NumberRepository numberRepository = new NumberRepository();
        Preprocessor preprocessor = new Preprocessor(numberRepository);
        preprocessor.Preprocessing(" 1 , 2 ");
        assert(numberRepository.getNumbers().size() == 2);
        assert(numberRepository.getNumbers().get(0) == 1);
        assert(numberRepository.getNumbers().get(1) == 2);
    
    }

    //잘못된 문자 에러 체크
    @Test
    @DisplayName("잘못된 문자 에러 테스트")
    public void invalidCharacterTest() {
        NumberRepository numberRepository = new NumberRepository();
        Preprocessor preprocessor = new Preprocessor(numberRepository);
        assertThrows(IllegalArgumentException.class, () -> {preprocessor.Preprocessing("1,a2");});
    }

    //정상 구동 체크
    @Test
    @DisplayName("정상 구동 테스트")
    public void normalProcessTest() {
        NumberRepository numberRepository = new NumberRepository();
        Preprocessor preprocessor = new Preprocessor(numberRepository);
        preprocessor.Preprocessing("1,2;3");
        assertEquals(numberRepository.getNumbers().size(), 3);
        assertEquals(numberRepository.getNumbers().get(0), 1);
        assertEquals(numberRepository.getNumbers().get(1), 2);
        assertEquals(numberRepository.getNumbers().get(2), 3);
    }


}
