package by.bsuir.trucking.command.logic;

import by.bsuir.trucking.command.Command;
import by.bsuir.trucking.dao.CargoDaoImpl;
import by.bsuir.trucking.dao.ShipDaoImpl;
import by.bsuir.trucking.entity.Batch;
import by.bsuir.trucking.entity.Cargo;
import by.bsuir.trucking.entity.Entity;
import by.bsuir.trucking.entity.Ship;
import com.sun.rowset.internal.Row;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.awt.print.Book;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;


public class ShipApp implements Command{
	@Override
	public Batch execute(Entity date) {

		ShipDaoImpl shipDao= new ShipDaoImpl();
		CargoDaoImpl cargoDao = new CargoDaoImpl();
		ArrayList<Cargo> arrayList= cargoDao.getAll();
		Ship sh =(Ship) date;
		Ship ship= shipDao.selectShipWeight(sh);
		if(ship.getDepartureDate()==null&& ship.getId()!=0){
		Boat k = new Boat(ship.getMaxWeight());
		for(Cargo cargo: arrayList)
		{
			if(cargo.getShipId()==0){
			k.items.add(new Item(cargo.getId(), cargo.getPrice(),cargo.getWeight()));}
		}
		Collections.sort(k.items);
		k.items.add(0,new Item(0,0,0));



		float totWeight=0;
		//Runs the Dynamic Boat

		System.out.println("\nДинамический метод:");
		totWeight=0;
		DynamicMethod sack3 = new DynamicMethod(k);

		ArrayList<Cargo> cargoArrayList = new ArrayList<Cargo>();
		Boat s = sack3.makeKnapSack();
		System.out.print("Погруженные грузы: ");
		for(Item i: s.items)
		{
			Cargo car = new Cargo();
			car.setId(i.getNumber());
			car.setWeight(i.getWeight());
			car.setPrice(i.getProfit());
			car.setShipId(ship.getId());
			cargoArrayList.add(car);
			cargoDao.sendCargo(car);
			System.out.print(" "+i.number);
			totWeight+=i.weight;
		}

		ship.setDepartureDate(new Date());
		shipDao.sendShip(ship);
		System.out.println("\nОбщая стоимость: " + s.profit);
		System.out.println("Общий вес: "+totWeight );

//		try {
//	writeExcel(cargoArrayList, ship);
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
			Batch batch = new Batch(true,null,null,null);
		return batch;
		}
		else return new Batch(false,null,null,null);
	}

//	private void writeExcel(ArrayList<Cargo> listBook, Ship ship) throws IOException {
//		Workbook workbook = new HSSFWorkbook();
//		Sheet sheet = workbook.createSheet();
//
//		int rowCount = 0;
//
//		HSSFRow ro = (HSSFRow) sheet.createRow(++rowCount);
//		Cell cel = ro.createCell(1);
//		cel.setCellValue("Номер корабля");
//
//		cel= ro.createCell(2);
//		cel.setCellValue("Номера погруженых грузов");
//
//		HSSFRow row = (HSSFRow) sheet.createRow(++rowCount);
//
//		Cell cell = row.createCell(1);
//		cell.setCellValue(ship.getId());
//		int i = 2;
//		for (Cargo aCargo : listBook) {
//			cell = row.createCell(i);
//			cell.setCellValue(aCargo.getId());
//			i++;
//		}
//
//		try (FileOutputStream outputStream = new FileOutputStream("ExcelFile.xls")) {
//			workbook.write(outputStream);
//		}
//	}


}
