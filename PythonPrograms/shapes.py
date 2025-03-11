
class Circle:

    def __init__(self, height, radius):
        self.height = height
        self.radius = radius

    def getArea(self):
        return 3.14 * self.radius * self.radius

    def getVolume(self):
        return 3.14 * self.radius * self.radius * self.height


class Cylinder(Circle):

    def __init__(self, height, radius):
        super().__init__(height, radius)

    def getArea(self):
        return 2 * 3.14 * self.radius * ( self.radius + self.height)

    def getVolume(self):
        return 3.14 * self.radius * self.radius * self.height


cyliderObj = Cylinder(3,6)
print("Cylinder area is ", cyliderObj.getArea())
print("Cylinder volume is ", cyliderObj.getVolume())

circleObj = Circle(3, 8)
print("Circle area is ", circleObj.getArea())
print("Circle volume is ", circleObj.getVolume())