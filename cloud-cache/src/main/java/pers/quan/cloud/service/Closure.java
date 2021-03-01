package pers.quan.cloud.service;

public interface Closure<O, I> {
	public O execute(I input);
}