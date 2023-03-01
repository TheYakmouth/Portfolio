import math
import sys


class RightTriangle:
    def __init__(self, a, o, h=0):
        try:
            self.a = float(a)
            self.o = float(o)
            self.h = float(h) or math.sqrt(math.pow(self.a, 2) + math.pow(self.o, 2))
        except ValueError:
            raise Exception("Input must be numbers")
        if self.a <= 0 or self.o <= 0:
            raise Exception("Input must be non-negative numbers")
        if abs(math.sqrt(math.pow(self.a, 2) + math.pow(self.o, 2)) - self.h) > .00001:
            raise Exception("Input must make a Pythagorean triple")

    def __eq__(self, other):
        if abs(self.h - other.h) > .00001:
            return False
        elif abs(self.a - other.a) < .00001 and abs(self.o - other.o) < .00001:
            return True
        elif abs(self.a - other.o) < .00001 and abs(self.o - other.a) < .00001:
            return True
        else:
            return False

    def __str__(self):
        return "Triangle Sides: " + str(self.a) + ", " + str(self.o) + " and Hypotenuse: " + str(self.h)


def main():
    t1 = None
    while t1 is None:
        sideA = input("Enter side A: ")
        sideB = input("Enter side B: ")
        try:
            t1 = RightTriangle(sideA, sideB)
        except Exception as e:
            print(e)
    print(t1)

    t2 = None
    while t2 is None:
        sideX = input("Enter side A: ")
        sideY = input("Enter side B: ")
        sideZ = input("Enter hypotenuse: ")
        try:
            t2 = RightTriangle(sideX, sideY, sideZ)
        except Exception as e:
            print(e)
    print(t2)

    print("Triangle 1 equal to itself? "+str(t1 == t1))
    print("Triangle 2 equal to itself? "+str(t2 == t2))
    print("Triangle 1 equal to Triangle 2? "+str(t1 == t2))


if __name__ == "__main__":
    sys.exit(main())
