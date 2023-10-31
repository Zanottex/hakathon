package com.example.demo;

import com.example.demo.Model.M_Arduino;
import com.example.demo.Service.S_Arduino;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fazecast.jSerialComm.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		initialize();

	}


	public static void initialize() {
		SerialPort[] ports = SerialPort.getCommPorts();
		SerialPort serialPort;
		if (ports.length == 0) {
			System.out.println("Nenhuma porta serial encontrada.");
			return;
		}

		serialPort = ports[1]; // Use a primeira porta serial encontrada, você pode ajustar isso conforme necessário

		if (!serialPort.openPort()) {
			System.out.println("Falha ao abrir a porta serial.");
			return;
		}

		serialPort.setComPortParameters(9600, 8, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);

		serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 10000, 0);


		BufferedReader input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
		OutputStream output = serialPort.getOutputStream();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		while (true) {
			try {
				if (input.ready()) {
					String temperatura = input.readLine();
					String pressao = input.readLine();
					String oleo = input.readLine();
					S_Arduino.infoArduino(temperatura, pressao, oleo);

					System.out.println("Dados recebidos (Temp): " + temperatura);
					System.out.println("Dados recebidos (pressao): " + pressao);
					System.out.println("Dados recebidos (oleo): " + oleo);

					// Faça o processamento necessário com os dados recebidos do teclado numérico
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}