import math
import sys


class Cylinder:
    def __init__(self, radius, height=1):
        try:
            self.radius = float(radius)
            self.height = float(height)
            self.volume = float(math.pow(self.radius, 2) * math.pi * self.height)
        except ValueError:
            raise Exception("Input must be float")
        if self.radius < 0:
            raise Exception("Radius must be greater than zero")
        if self.height < 0:
            raise Exception("Height must be greater than zero")

    def __eq__(self, other):
        if other is None:
            return False
        if abs(self.volume - other.volume) < 0.001:
            return True
        else:
            return False

    def __str__(self):
        return "Cylinder with Radius: " + str(self.radius) + " and Height: " + str(self.height) + " has Volume: " + str(
            self.volume)


def main():
    c1 = None
    while c1 is None:
        radius = input("Enter radius: ")
        try:
            c1 = Cylinder(radius)
        except Exception as e:
            print(e)
    print(c1)

    c2 = None
    while c2 is None:
        radius = input("Enter radius: ")
        height = input("Enter height: ")
        try:
            c2 = Cylinder(radius, height)
        except Exception as e:
            print(e)
    print(c2)

    print("Cylinder 1 equal to itself? " + str(c1 == c1))
    print("Cylinder 1 equal to Cylinder 2? " + str(c1 == c2))


if __name__ == "__main__":
    sys.exit(main())
