package org.amtel.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BoxTest {
    Box box;




    @Nested
    class WhenEmptyBox {

        @BeforeEach    // @BeforeEach ����� ����������� ��� ���� ��������� ������� (WhenOneBall � ��)
        void createEmptyBox() {
            box = new Box();
        }

        @Test
        void whereDeleteBallThenException() {
            Assertions.assertThrows(BoxIsEmptyExeption.class, () -> box.deleteBall());
        }


        @Nested
        class WhenOneBall {

            @BeforeEach
            void addBall() {
                box.addBall();
            }

            @Test  //��� ����� ����� ����� ������� ��� @BeforeEach �� ���� ������������ �������
            void deleteBall() throws BoxIsEmptyExeption {
                box.deleteBall();
                Assertions.assertEquals(0, box.getBallsCount());
            }




            @Nested
            class WhenALotOfBalls {

                @BeforeEach
                void addBall() {
                    box.addBall();
                    box.addBall();
                    box.addBall();
                    box.addBall();
                }

                @Test  //��� ����� ����� ����� ������� ��� @BeforeEach �� ���� ������������ �������
                void deleteBall() throws BoxIsEmptyExeption {
                    //box.deleteBall();
                    //Assertions.assertEquals(0, box.getBallsCount());
                }
            }
        }


    }



    @Nested
    class TestCl {



    }








}
