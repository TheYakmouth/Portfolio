import sys

class Vehicle:
	def __init__(self, weight):
		self._weight = weight
	
	def __str__(self):
		return "vehicle with weight = "+str(self._weight)
	
	def get_weight(self):
		return self._weight

class Truck(Vehicle):
	def __init__(self, weight, haul_capacity):
		self._weight = weight
		self._haul_capacity = haul_capacity

	def get_haul_capacity(self):
		return self._haul_capacity

	def __str__(self):
		return "truck with weight = "+str(self._weight)+" and hauling capacity "+str(self._haul_capacity)

class Car(Vehicle):
	def __init__(self, weight, convertible):
		self._weight = weight
		self._convertible = convertible
	
	def get_is_convertible(self):
		return self._convertible
	
	def __str__(self):
		if(self._convertible == True):
			return "car with weight = "+str(self._weight)+" is a convertible"
		else:
			return "car with weight = "+str(self._weight)+" is not a convertible"

def main():
	car_list = [Vehicle(1000), Truck(2000, 2500), Car(1000, True), Car(1000, False)]
	for vehicle in car_list:
		print(vehicle)

if __name__ == "__main__":
    sys.exit(main())
