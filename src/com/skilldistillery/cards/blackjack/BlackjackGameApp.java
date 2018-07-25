package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;

public class BlackjackGameApp {
	Scanner sc = new Scanner(System.in);
	Deck deck = new Deck();
	String playerName;
	private Hand playerHand;
	private Hand dealerHand;

	public static void main(String[] args) {
		BlackjackGameApp bjga = new BlackjackGameApp();
		bjga.run();
	}

	public void run() {
		String playerMove;
		introduction();
		while (playAgain() == true) {
			initialHands();
			if (playerHand.getHandValue() == 21 && dealerHand.getHandValue() == 21) {
				System.out.println("You and the dealer have a blackjack... This round is a draw");
				break;
			} else if (playerHand.getHandValue() == 21) {
				System.out.println("You have a BLACKJACK!");
				break;
			}
			System.out.println("\n" + playerName + ", would you like to hit or stay?");
			playerMove = sc.nextLine();
			if (playerMove.equalsIgnoreCase("Hit")) {
				while (playerMove.equalsIgnoreCase("Hit")) {
					playerHit();
					if (playerHand.getHandValue() > 21) {
						System.out.println("\nYou have busted! The dealer wins this hand.");
						break;
					}
					if (playerHand.getHandValue() <= 21) {
						System.out.println("\nWould you like to Hit or Stay?");
						playerMove = sc.nextLine();
					}
				}
			}
			if (playerMove.equalsIgnoreCase("Stay")) {
				dealerHit();
			}
			determineWinner();
		}
	}

	public Boolean playAgain() {
		Boolean playAgain = null;
		System.out.println("\nWould you like to play a game of blackjack?");
		String playBlackjack = sc.nextLine();
		if (playBlackjack.equalsIgnoreCase("Yes")) {
			System.out.println("Lets play some blackjack " + playerName + "!\n");
			return true;
		} else if (playBlackjack.equalsIgnoreCase("No")) {
			return false;
		}
		return playAgain;
	}

	public void introduction() {
		System.out.print("Welcome to a game of blackjack!\nWhat is your name?\n");
		playerName = sc.nextLine();
	}

	public void initialHands() {
		// Initial hands for the player and dealer
		playerHand = new BlackjackHand();
		dealerHand = new BlackjackHand();

		playerHand.addCard(deck.dealCard());
		dealerHand.addCard(deck.dealCard());
		playerHand.addCard(deck.dealCard());
		System.out.println(playerName + "'s hand:");
		System.out.print(playerHand);
		System.out.println(playerHand.getHandValue());
		System.out.println("\nDealer's hand:\n\uD83C\uDCE0");
		System.out.print(dealerHand);
		System.out.println(dealerHand.getHandValue());
		dealerHand.addCard(deck.dealCard());
	}

	public void playerHit() {
		playerHand.addCard(deck.dealCard());
		System.out.print("\n" + playerName + "'s hand:\n" + playerHand);
		System.out.print(playerHand.getHandValue());
	}

	public void blackjack() {
		if (playerHand.getHandValue() == 21 && dealerHand.getHandValue() == 21) {
			System.out.println("You and the dealer have a blackjack... This round is a draw");

			;
		} else if (playerHand.getHandValue() == 21) {
			System.out.println("You have a BLACKJACK!");
			;
		}
	}

	public void dealerHit() {
		if (dealerHand.getHandValue() >= 17) {
			System.out.print(dealerHand);
			System.out.println(dealerHand.getHandValue());
		}
		while (dealerHand.getHandValue() < 17) {
			dealerHand.addCard(deck.dealCard());
			System.out.print("\nDealer draws a card...\nDealer's hand:\n" + dealerHand);
			System.out.println(dealerHand.getHandValue());
			if (dealerHand.getHandValue() > 21 && playerHand.getHandValue() <= 21) {
				System.out.println("\nThe dealer busted... You WIN this hand!");
			}
		}
	}

	public void determineWinner() {
		if (dealerHand.getHandValue() <= 21 && playerHand.getHandValue() > dealerHand.getHandValue()
				&& playerHand.getHandValue() <= 21) {
			System.out.println("\nYou WIN this hand!");
		}
		if (dealerHand.getHandValue() <= 21 && playerHand.getHandValue() <= 21
				&& playerHand.getHandValue() == dealerHand.getHandValue()) {
			System.out.println("This round is a draw...");
		}
		if (dealerHand.getHandValue() <= 21 && playerHand.getHandValue() <= 21
				&& dealerHand.getHandValue() > playerHand.getHandValue()) {
			System.out.println("The dealer wins this round.");
		}
	}

}
