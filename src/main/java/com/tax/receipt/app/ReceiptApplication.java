package com.tax.receipt.app;

import java.io.IOException;
import java.util.Arrays;

import com.tax.receipt.processor.ReceiptProcessor;

public class ReceiptApplication {
	public static void main(String[] args) throws IOException {
		if (args.length < 1) {
			System.out.println("Please provide input file path");
			System.exit(-1);
		}

		Arrays.stream(args).forEach(ReceiptProcessor::processFile);
	}
}