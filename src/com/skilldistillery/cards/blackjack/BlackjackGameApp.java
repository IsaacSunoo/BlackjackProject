package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;

public class BlackjackGameApp {
	Deck deck = new Deck();
	private Hand playerHand;
	private Hand dealerHand;

	public static void main(String[] args) {
		BlackjackGameApp bjga = new BlackjackGameApp();
		bjga.playerTurn();
		bjga.playAnotherHand();

	}

	public void initialHands() {
		// Initial hands for the player and dealer
		playerHand = new BlackjackHand();
		dealerHand = new BlackjackHand();

		playerHand.addCard(deck.dealCard());
		dealerHand.addCard(deck.dealCard());
		playerHand.addCard(deck.dealCard());
		System.out.println("Player's hand:");
		System.out.print(playerHand);
		System.out.println(playerHand.getHandValue());
		System.out.println("\nDealer's hand:\n\uD83C\uDCE0");
		System.out.print(dealerHand);
		System.out.println(dealerHand.getHandValue());
		dealerHand.addCard(deck.dealCard());

//		if (playerHand.getHandValue() == 21 ) {
//			System.out.println("BLACKJACK!");
//			if(dealerHand.getHandValue() == 21) {
//				System.out.println("This round is a push...");
//			}
	}

	public void playerTurn() {
		Scanner sc = new Scanner(System.in);
		String playerMove;
//		String playAgain = null;
		initialHands();
		// need to implement a blackjack method in case player gets 21 on the first
		// hand.
		if (playerHand.getHandValue() == 21) {
			System.out.println("You have a BLACKJACK!");
			return;
		}
//		while(playAgain.equalsIgnoreCase("Quit") || playAgain.equalsIgnoreCase("Exit")){

		System.out.println("\nWould you like to Hit or Stay?");
		playerMove = sc.nextLine();
		while (playerHand.getHandValue() < 21 && playerMove.equalsIgnoreCase("Stay")) {
			System.out.println("\nDealer's hand: \n" + dealerHand);
			System.out.println(dealerHand.getHandValue());
			if (dealerHand.getHandValue() < 17) {
				dealerHand.addCard(deck.dealCard());
				System.out.println("\n" + dealerHand);
				System.out.print(dealerHand.getHandValue());
			}
			if (dealerHand.getHandValue() <= 21 && playerHand.getHandValue() <= 21) {
				if (dealerHand.getHandValue() > playerHand.getHandValue()) {
					System.out.println("\nDealer wins this hand.");
					return;
				} else if (playerHand.getHandValue() > dealerHand.getHandValue()) {
					System.out.println("You WIN this hand!");
					return;
				}
			}
			if (dealerHand.getHandValue() > 21 && playerHand.getHandValue() <= 21) {
				System.out.println("\nThe dealer busted... You WIN this hand!");
				return;
			}
//					if (dealerHand.getHandValue() <= 21 && dealerHand.getHandValue() > playerHand.getHandValue()) {

//					}
			while (playerMove.equalsIgnoreCase("Hit")) {
				playerHand.addCard(deck.dealCard());
				System.out.print("\n" + playerHand);
				System.out.print(playerHand.getHandValue());
			}
			if (playerHand.getHandValue() <= 21) {
				System.out.println("\nWould you like to Hit or Stay?");
				playerMove = sc.nextLine();
				playerHand.addCard(deck.dealCard());
				System.out.println("\n" + playerHand);
				System.out.print(playerHand.getHandValue());
			} else if (playerHand.getHandValue() > 21) {
				System.out.println("\nYou have busted!");
				return;
			}
		}
	}

	public void playAnotherHand() {
		Scanner sc = new Scanner(System.in);
		String playerMove;

		System.out.print("Would you like to play another hand? (Yes/Quit) : ");
		playerMove = sc.nextLine();
		while (playerMove.equalsIgnoreCase("Yes") || playerMove.equalsIgnoreCase("Quit")) {
			if (playerMove.equalsIgnoreCase("Yes")) {
				playerTurn();
			}
			if (playerMove.equalsIgnoreCase("Quit")) {
				System.exit(0);
			}
			sc.close();
		}
	}
}

//	public void blackjack() {
//		Scanner sc = new Scanner(System.in);
//		while (playerHand.getHandValue() == 21 ) {
//			System.out.println("You have a BLACKJACK!");
//			System.out.println("Would you like to play another round?");
//			String playAgain = sc.nextLine();
//			if (playAgain.equalsIgnoreCase("Yes")) {
//				continue;
//			}
//			playerTurn();
//		}
//		
