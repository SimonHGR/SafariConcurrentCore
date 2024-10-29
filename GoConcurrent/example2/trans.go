package main

import (
	"fmt"
	"sync"
	"time"
)

var x = 0
var y = 0

var lock sync.Mutex

func updater() {
	for c := 0; c < 1_000; c++ {
		lock.Lock()
		x++
		time.Sleep(1 * time.Millisecond)
		y++
		time.Sleep(1 * time.Millisecond)
		lock.Unlock()
	}
	fmt.Println("updating done")
}

func getXY() (a, b int) {
	lock.Lock()
	defer func() {
		lock.Unlock()
	}()
	a, b = x, y
	return // a, b implicitly
}

func reader() {
	for a, b := getXY(); a < 1000; a, b = getXY() {
		if a != b {
			fmt.Println("Error!! x read as", a, "y read as", b)
		}
	}
}

func main() {
	go updater()
	go reader()
	time.Sleep(5 * time.Second)
}
