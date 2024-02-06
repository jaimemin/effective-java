package com.tistory.jaimemin.effectivejava.ch03.item20.typeframework;

public interface SingerSongwriter extends Singer, Songwriter {

	AudioClip strum();

	void actSensitive();
}
