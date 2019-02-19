/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package row;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author ariarti
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Создаём объекты 
        
        Row myRow28 = new Row(28);

        Row myRow120 = new Row(120);

        Row myRow500 = new Row(500);
    }

}

class Row {
    
    // количество выведенных чисел
    private int N;                 
    
    // разрядность числа из цикла
    private int num = 1;
    
    // счетчик выведенных чисел
    private int s = 1;
    
    // строка с полученной информацией
    private String text;
    
    // Конструктор (задаём количество выведенных чисел)
    Row(int N) {
        this.N = N;
        this.est();
    }
    // Метод нахождения вывода и записи в файл note.txt полученных значений
    private void est() {
        for (int i = 0; true; i++) {
            if (i != 0) {
                num = (int) Math.log10(i) + 1;  // Получаем разрядность числа
            }
            if (i % num == 0) {
                text = "When N = " + N + " then i = " + i + "\n";
                
                // Вывод значения в консоль
                System.out.print(text);
                
                // Запись в файл .txt
                try (FileOutputStream wnote = new FileOutputStream("note.txt", true)) {
                    
                    // Перевод строки в байты
                    byte[] buffer = text.getBytes();
                    
                    // Запись
                    wnote.write(buffer, 0, buffer.length);

                } catch (IOException ex) {

                    System.out.println(ex.getMessage());
                }
                
                   // При достижении заданного значения N прерываем цикл
                   if (N == s) break; 
                   
                   s++;
            }
        }
    }
}
