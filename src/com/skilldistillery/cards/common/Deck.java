package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck = new ArrayList<>();

	public Deck() {
		makeDeck();
	}

	public List<Card> getCards() {
		return deck;
	}

	public void setCards(List<Card> cards) {
		this.deck = cards;
	}

	private void makeDeck() {
		Suit[] suitArr = Suit.values();
		Rank[] rankArr = Rank.values();
		for (Suit suit : suitArr) {
			for (Rank rank : rankArr) {
				deck.add(new Card(rank, suit));
			}
		}
		shuffleDeck();
	}

	public int checkDeckSize() {
		int numCardsLeft = deck.size();

		return numCardsLeft;
	}

	public Card dealCard() {
		if (checkDeckSize() < 10) {
			makeDeck();
		}
		Card dealt = deck.remove(0);
		
		return dealt;
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
}
