class Widget:
    def __init__(self, characteristic_a, characteristic_b):
        self._characteristic_a = characteristic_a
        self._characteristic_b = characteristic_b

    def __eq__(self, other):
        if ((self._characteristic_a == other._characteristic_a) and (
                self._characteristic_b == other._characteristic_b)):
            return True
        else:
            return False

    def __add__(self, other):
        return Widget(self._characteristic_a + other._characteristic_a,
                      self._characteristic_b + other._characteristic_b)

    def __str__(self):
        return 'Widget with characteristic a = ' + str(self._characteristic_a) + ' and characteristic b = ' + str(
            self._characteristic_b)
