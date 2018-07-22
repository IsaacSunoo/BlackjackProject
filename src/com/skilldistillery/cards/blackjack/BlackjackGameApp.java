package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Deck;

public class BlackjackGameApp{
	Deck deck = new Deck();
	private Hand playerHand;
	private Hand dealerHand;
	
	public static void main(String[] args) {
		BlackjackGameApp bjga = new BlackjackGameApp();
		bjga.initialHands();
	
	}
	
	public void initialHands() {
		playerHand = new BlackjackHand();
		dealerHand = new BlackjackHand();
		
		playerHand.addCard(deck.dealCard());
		dealerHand.addCard(deck.dealCard());
		playerHand.addCard(deck.dealCard());
		System.out.println(playerHand);
		System.out.println(playerHand.getHandValue());
		System.out.println();
		System.out.println(dealerHand);
		System.out.println(dealerHand.getHandValue());
		dealerHand.addCard(deck.dealCard());
	}
	
	

	
	
	
	
	
}
