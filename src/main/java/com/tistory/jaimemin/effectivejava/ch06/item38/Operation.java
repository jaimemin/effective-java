package com.tistory.jaimemin.effectivejava.ch06.item38;

// Emulated extensible enum using an interface (Page 176)
public interface Operation {
	
	double apply(double x, double y);
}
