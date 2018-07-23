package com.skilldistillery.cards.common;

public enum Suit {
  HEARTS("\u2665" + "'s"), SPADES("\u2660" + "'s"), CLUBS("\u2663" + "'s"), DIAMONDS("\u2666" + "'s");
  private String name;

  Suit(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}