package main

import (
	"fmt"
)

func Job(name string) {
	fmt.Println("Job starting")
	for x := 0; x < 1_000; x++ {
		fmt.Println(name, "x is", x)
	}
	fmt.Println("Job ending")
}

func main() {
	fmt.Println("Starting the goroutine")
	go Job("A")
	fmt.Println("goroutine started")
	fmt.Println("main exiting...")
	// time.Sleep(1 * time.Second)
}
