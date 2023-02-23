import java.util.Scanner;

class Fahrkartenautomat {
	public static void main(String[] args) {

		Scanner tastatur = new Scanner(System.in);

		double zuZahlenderBetrag = 0;
		double ticketAnzahl = 0;
		double eingezahlterGesamtbetrag;
		double eingeworfeneMuenze;
		double rueckgabebetrag;
		double nochZuZahlen;
		int tickettyp = 0;
		boolean auswahlvorgang = true;

		// Gelbetrag eingeben

		while (tickettyp < 1 || tickettyp > 4) {
			System.out.println("Wählen Sie Ihre Wunschfahrkarte für Berlin AB aus: ");
			System.out.println("  Kurzstrecke AB [2,00 EUR] (1)");
			System.out.println("  Einzelfahrschein AB [3,00 EUR] (2)");
			System.out.println("  Tageskarte AB [8,80 EUR] (3)");
			System.out.println("  4-Fahrten-Karte AB [9,40 EUR] (4)");
			tickettyp = tastatur.nextInt();
			switch (tickettyp) {
				case 1:
					zuZahlenderBetrag = 2;
					break;
				case 2:
					zuZahlenderBetrag = 3;
					break;
				case 3:
					zuZahlenderBetrag = 8.8;
					break;
				case 4:
					zuZahlenderBetrag = 9.4;
					break;
				default:
			}
		}
//		while (auswahlvorgang = true) {
//			while (tickettyp < 1 || tickettyp > 4) {
//				System.out.println("Wählen Sie Ihre Wunschfahrkarte für Berlin AB aus: ");
//				System.out.println("  Kurzstrecke AB [2,00 EUR] (1)");
//				System.out.println("  Einzelfahrschein AB [3,00 EUR] (2)");
//				System.out.println("  Tageskarte AB [8,80 EUR] (3)");
//				System.out.println("  4-Fahrten-Karte AB [9,40 EUR] (4)");
//				System.out.println("    Bezahlen (9)");
//				tickettyp = tastatur.nextInt();
//				switch (tickettyp) {
//				case 1:
//					zuZahlenderBetrag = 2;
//					break;
//				case 2:
//					zuZahlenderBetrag = 3;
//					break;
//				case 3:
//					zuZahlenderBetrag = 8.8;
//					break;
//				case 4:
//					zuZahlenderBetrag = 9.4;
//					break;
//				case 9:
//					auswahlvorgang = false;
//				default:
//				}
//			}
//			
//			System.out.println("Ihre Wahl: " + tickettyp);
//			System.out.print("Anzahl der Tickets: ");
//			ticketAnzahl = tastatur.nextDouble();
//
//			while (ticketAnzahl > 10 || ticketAnzahl < 1) {
//				System.out.println("Anzahl der Tickets: ");
//				ticketAnzahl = tastatur.nextDouble();
////				ticketAnzahl = 1;
//			}
//		}

//		if (zuZahlenderBetrag < 0) {
//			System.out.println("Fehlerhafte Eingabe - Ticketpreis wird auf 1 gesetzt");
//			zuZahlenderBetrag = 1;
//		}

//		System.out.println("Ihre Wahl: " + tickettyp);
//		System.out.print("Anzahl der Tickets: ");
//		ticketAnzahl = tastatur.nextDouble();
//
//		while (ticketAnzahl > 10 || ticketAnzahl < 1) {
//			System.out.println("Anzahl der Tickets: ");
//			ticketAnzahl = tastatur.nextDouble();
////			ticketAnzahl = 1;
//		}

		// Geldeinwurf
		eingezahlterGesamtbetrag = 0.0;
		nochZuZahlen = 0.0;
//		if (ticketAnzahl <= 10 && ticketAnzahl >= 1 && zuZahlenderBetrag > 0)	{
		while (eingezahlterGesamtbetrag < ticketAnzahl * zuZahlenderBetrag) {
			nochZuZahlen = ticketAnzahl * zuZahlenderBetrag - eingezahlterGesamtbetrag;
			System.out.printf("Noch zu zahlen: " + "%.2f\n", nochZuZahlen);
			System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro): ");
			eingeworfeneMuenze = tastatur.nextDouble();
			eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
		}

		// Fahrschein ausgabe
		System.out.println("\nFahrschein wird ausgegeben");
		for (int i = 0; i < 8; i++) {
			System.out.print("=");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("\n\n");

		// Rückgeldberechnung und -ausgabe
		rueckgabebetrag = eingezahlterGesamtbetrag - ticketAnzahl * zuZahlenderBetrag;
		if (rueckgabebetrag > 0.0) {
			System.out.println("Der Rückgabebetrag in Höhe von " + rueckgabebetrag + " Euro");
			System.out.println("wird in folgenden Münzen ausgezahlt:");

			while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
				System.out.println("2 Euro");
				rueckgabebetrag = rueckgabebetrag - 2.0;
			}
			while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
				System.out.println("1 Euro");
				rueckgabebetrag = rueckgabebetrag - 1.0;
			}
			while (rueckgabebetrag >= 0.5) { // 50-Cent-Münzen
				System.out.println("50 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.5;
			}
			while (rueckgabebetrag >= 0.2) { // 20-Cent-Münzen
				System.out.println("20 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.2;
			}
			while (rueckgabebetrag >= 0.1) { // 10-Cent-Münzen
				System.out.println("10 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.1;
			}
			while (rueckgabebetrag >= 0.05) { // 5-Cent-Münzen
				System.out.println("5 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.05;
			}
		}

		System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
				+ "Wir wünschen Ihnen eine gute Fahrt.");
//		System.out.println("Test");
		tastatur.close();
	}
}