package main

import (
	"fmt"
	"time"
)

func producer(data chan<- []int, cont chan bool) {
	var d []int
	for x := 1; x < 1000; x++ {
		d = []int{x, 0}
		time.Sleep(1 * time.Microsecond)
		d[1] = x
		if x == 500 {
			d[0] = -1 // test the receiver test
		}
		data <- d
	}
	fmt.Println("producer finished")
	cont <- true
}

func consumer(data <-chan []int, cont chan bool) {
	var d []int
	for x := 1; x < 1000; x++ {
		d = <-data
		if d[0] != x || d[1] != x {
			fmt.Printf("Problem, at index %d, got %v\n", x, d)
		}
	}
	fmt.Println("consumer finished")
	cont <- true
}

func main() {
	control := make(chan bool)
	ch := make(chan []int)
	go producer(ch, control)
	go consumer(ch, control)
	_ = <-control
	_ = <-control
	fmt.Println("main finished")
}
