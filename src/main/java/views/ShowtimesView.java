/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.time.format.DateTimeFormatter;
import java.util.List;
import models.Showtimes;

/**
 *
 * @author MSII
 */
public class ShowtimesView {
    
    private String listToString(List<String> input){
        StringBuilder rs = new StringBuilder();
        input.forEach(e -> rs.append(e).append(" "));
        return rs.toString().trim();
    }
    
    public void showAll(List<Showtimes> listshowTimes){
        if(listshowTimes.isEmpty()){
            System.out.println("Lich chieu dang trong! Ban vui long quay lai sau");
            return;
        }
        listshowTimes.forEach(e -> System.out.printf("\n\n%s\n%s    Dao Dien: %s\nPhong: %s    Rap: %s\nNgay cong chieu: %s\nSo ghe: %d    So ghe con lai: %d\n",
                e.getMovie().getName(),
                listToString(e.getMovie().getGenre()),
                listToString(e.getMovie().getDirector()),
                e.getRoom(),
                e.getTheater(),
                e.getDateTime().format(DateTimeFormatter.ofPattern("HH:mm:ss - dd/MM/yyyy")),
                e.getSeats(),
                e.getSeats() - e.getSelectedSeats()
                ));
    }
}
