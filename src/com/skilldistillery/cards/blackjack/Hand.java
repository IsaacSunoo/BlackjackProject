package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Rank;
import com.skilldistillery.cards.common.Suit;

public abstract class Hand {
//	public static void main(String[] args) {
//		Hand h = new Hand();
//		h.addCard(new Card(Rank.ACE, Suit.SPADES));
//		h.addCard(new Card(Rank.KING, Suit.HEARTS));
//		h.addCard(new Card(Rank.SEVEN, Suit.CLUBS));
//		System.out.println(h.toString());
//		System.out.println(h.getHandValue());
//	}
	private List<Card> cards = new ArrayList<>();

	public Hand() {

	}

	public int getHandValue() {
		int totalValue = 0;

		for (int i = 0; i < cards.size(); i++) {
			Card c = cards.get(i);
			int value = c.getValue();
			totalValue += value;
		}
		return totalValue;
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}

	public void clearHand() {
		cards.clear();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cards.size(); i++) {
			Card c = cards.get(i);
			sb.append(c + "\n");
		}
		return sb.toString();
	}

}
