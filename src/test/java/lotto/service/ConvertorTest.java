package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ConvertorTest {

    @DisplayName("구입금액이 1,000원으로 나누어 떨어지지 않는 경우")
    @Test
    void getQuantityByWrongUnit() {
        //then
        assertThatThrownBy(() -> Convertor.getQuantity("1111"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액에 숫자가 들어오지 않는 경우")
    @Test
    void getQuantityByNotNumber() {
        //then
        assertThatThrownBy(() -> Convertor.getQuantity("100a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개의 숫자가 아닐 경우")
    @Test
    void getNumbersByWrongSize() {
        //then
        assertThatThrownBy(() -> Convertor.getNumbers("1,2,3,4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 범위가 1~45자리가 아닐 경우")
    @Test
    void getNumbersByWrongRange() {
        //then
        assertThatThrownBy(() -> Convertor.getNumbers("1,2,3,4,77,2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자일 경우")
    @Test
    void getNumbersByDuplication() {
        //then
        assertThatThrownBy(() -> Convertor.getNumbers("1,2,3,4,4,4"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
