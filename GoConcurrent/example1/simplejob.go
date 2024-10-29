package main

import (
	"fmt"
	"time"
)

var x = 0

func Job(name string) {
	fmt.Println("Job starting")
	for ; /*x := 0*/ x < 1_000; x++ {
		fmt.Println(name, "x is", x)
	}
	fmt.Println("Job ending")
}

func main() {
	fmt.Println("Starting the goroutine")
	go Job("A")
	go Job("B")
	fmt.Println("goroutine started")
	fmt.Println("main exiting...")
	time.Sleep(1 * time.Second)
}
