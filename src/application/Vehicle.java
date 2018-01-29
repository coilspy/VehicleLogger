package application;

import sun.util.calendar.BaseCalendar;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Vehicle {
    //Traits
    String name;
    int year;
    int mileage;
    int serviceInterval;

    //Service related data
    Date dateOfLastService;
    int mileageOfLastService;

    public int getMileageDifference()
    {
        return this.mileage - this.mileageOfLastService;
    }

    public long getDaysSinceLastService(Date date1, Date date2, TimeUnit timeUnit)
    {
        long days = date2.getTime() - date1.getTime();
        return timeUnit.toDays(days);
    }

    public void service(int newMileage, Date dateOfService)
    {
        dateOfLastService = dateOfService;
        this.mileage = newMileage;
    }

    public void PrintVehicleInfoToFile(Vehicle vehic)
    {
        String printString = name + "; " + year + "; " + mileage + "; " + dateOfLastService + "; " + mileageOfLastService;
        try(PrintWriter printWriter = new PrintWriter(new BufferedWriter((new FileWriter("vehicles.txt", true)))))
        {
            printWriter.write(printString+ "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Vehicle(String name, int year, int mileage, int serviceInterval){
        this.name = name;
        this.year = year;
        this.mileage = mileage;
        this.serviceInterval = serviceInterval;
    }
}
