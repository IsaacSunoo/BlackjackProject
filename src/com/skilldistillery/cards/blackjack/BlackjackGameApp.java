package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;

public class BlackjackGameApp {
	Scanner sc = new Scanner(System.in);
	Deck deck = new Deck();
	private Hand playerHand;
	private Hand dealerHand;
	String playerMove;
	String playerChoice;

	public static void main(String[] args) {
		BlackjackGameApp bjga = new BlackjackGameApp();
		bjga.playerTurn();
//		bjga.playAnotherHand();
		System.out.println("\nsimultion over");

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
		initialHands();
//		blackjack();
		if (playerHand.getHandValue() == 21 && dealerHand.getHandValue() == 21) {
			System.out.println("You and the dealer have a blackjack... This round is a draw");
			System.exit(0);
			;
		} else if (playerHand.getHandValue() == 21) {
			System.out.println("You have a BLACKJACK!");
			System.exit(0);
		}

		System.out.println("\nWould you like to Hit or Stay?");
		playerMove = sc.nextLine();

		if (playerMove.equalsIgnoreCase("Hit") && playerHand.getHandValue() <= 21) {
			playerHand.addCard(deck.dealCard());
			System.out.print("\nPlayer's hand:\n" + playerHand);
			System.out.print(playerHand.getHandValue());
			if (playerHand.getHandValue() > 21) {
				System.out.println("\nYou have busted!");
				return;
			}
			if (playerHand.getHandValue() <= 21) {
				System.out.println("\nWould you like to Hit or Stay?");
				playerMove = sc.nextLine();

				if (playerMove.equalsIgnoreCase("Hit") && playerHand.getHandValue() <= 21) {
					playerHand.addCard(deck.dealCard());
					System.out.print("\nPlayer's hand:\n" + playerHand);
					System.out.print(playerHand.getHandValue());
					if (playerHand.getHandValue() > 21) {
						System.out.println("\nYou have busted! Dealer takes this hand.");
						return;
					}
					else if (playerHand.getHandValue() <= 21) {
						System.out.println("\nWould you like to Hit or Stay?");
						playerMove = sc.nextLine();
					} 
				}
			}
		}
					if (playerMove.equalsIgnoreCase("Stay")) {
						while(dealerHand.getHandValue() < 18) {
						dealerHand.addCard(deck.dealCard());
						System.out.print("\nDealer's hand:\n" + dealerHand);
						System.out.println(dealerHand.getHandValue());
						}
						if (dealerHand.getHandValue() >= 17 && playerHand.getHandValue() > dealerHand.getHandValue()
								&& playerHand.getHandValue() <= 21) {
							System.out.println("\nYou WIN this hand!");
						}
						if (dealerHand.getHandValue() > 21 && playerHand.getHandValue() <= 21) {
							System.out.println("\nThe dealer busted... You WIN this hand!");
						}
						if (dealerHand.getHandValue() <= 21 && playerHand.getHandValue() <= 21
								&& playerHand.getHandValue() == dealerHand.getHandValue()) {
							System.out.println("This round is a draw...");
							if (dealerHand.getHandValue() <= 21 && playerHand.getHandValue() <= 21
									&& dealerHand.getHandValue() > playerHand.getHandValue()) {
								System.out.println("The dealer wins this round.");
							}
					}
				}
			
		 if (playerMove.equalsIgnoreCase("Stay") && dealerHand.getHandValue() < 18) {
			dealerHand.addCard(deck.dealCard());
			System.out.print("\nDealer's hand: \n" + dealerHand);
			System.out.println(dealerHand.getHandValue());
			if (dealerHand.getHandValue() > 21 && playerHand.getHandValue() <= 21) {
				System.out.println("\nThe dealer busted... You WIN this hand!");
			}
			if (dealerHand.getHandValue() >= 17 && playerHand.getHandValue() > dealerHand.getHandValue()
					&& playerHand.getHandValue() <= 21) {
				System.out.println("\nYou WIN this hand!");
			}
			if (dealerHand.getHandValue() <= 21 && playerHand.getHandValue() <= 21
					&& playerHand.getHandValue() == dealerHand.getHandValue()) {
				System.out.println("This round is a draw...");
				if (dealerHand.getHandValue() <= 21 && playerHand.getHandValue() <= 21
						&& dealerHand.getHandValue() > playerHand.getHandValue()) {
					System.out.println("The dealer wins this round.");
				}
			}
		}
	}

	public void playerChoice() {
		System.out.println("\nWould you like to Hit or Stay?");
		playerMove = sc.nextLine();
		if (playerMove.equalsIgnoreCase("Stay")) {
			playerStay();
		} else if (playerMove.equalsIgnoreCase("Hit")) {
			playerHit();
		}
	}

	public void playerHit() {
		if (playerHand.getHandValue() <= 21) {
			playerHand.addCard(deck.dealCard());
			System.out.print("\nPlayer's hand:\n" + playerHand);
			System.out.print(playerHand.getHandValue());

		} else if (playerHand.getHandValue() > 21) {
			System.out.println("\nYou have busted!");
			return;
		}
//			playerChoice();
	}

	public void playerStay() {
		while (dealerHand.getHandValue() < 18) {
			dealerHand.addCard(deck.dealCard());
			System.out.println("\nDealer's hand: \n" + dealerHand);
			System.out.print(dealerHand.getHandValue());
			if (dealerHand.getHandValue() > 21 && playerHand.getHandValue() <= 21) {
				System.out.println("\nThe dealer busted... You WIN this hand!");
			}
			if (dealerHand.getHandValue() >= 17 && playerHand.getHandValue() > dealerHand.getHandValue()
					&& playerHand.getHandValue() <= 21) {
				System.out.println("\nYou WIN this hand!");
			}
			if (dealerHand.getHandValue() <= 21 && playerHand.getHandValue() <= 21
					&& playerHand.getHandValue() == dealerHand.getHandValue()) {
				System.out.println("This round is a draw...");
				if (dealerHand.getHandValue() <= 21 && playerHand.getHandValue() <= 21
						&& dealerHand.getHandValue() > playerHand.getHandValue()) {
					System.out.println("The dealer wins this round.");
				}
			}
		}
	}

	public void blackjack() {
		if (playerHand.getHandValue() == 21 && dealerHand.getHandValue() == 21) {
			System.out.println("You and the dealer have a blackjack... This round is a draw");
			System.exit(0);
			;
		} else if (playerHand.getHandValue() == 21) {
			System.out.println("You have a BLACKJACK!");
			System.exit(0);
			;
		}
	}

	public void playAnotherHand() {
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
