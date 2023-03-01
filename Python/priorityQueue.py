import sys


def main():
    pq = PQ()
    pq.add(2, "Eat")
    pq.add(0, "Study")
    pq.add(3, "Sleep")
    pq.add(1, "Maintain Personal Relationships")
    pq.add(4, "Practice Good Personal Hygiene")
    pq.set_priority("Practice Good Personal Hygiene", 2)
    pq.set_priority("Eat", 4)
    while pq.size() > 0:
        print(pq.remove_min())


class Entry:
    def __init__(self, priority, value):
        self.priority = priority
        self.value = value

    def set_priority(self, priority):
        self.priority = priority

    def get_priority(self):
        return self.priority

    def get_value(self):
        return self.value

    def __str__(self):
        return "Priority: " + str(self.priority) + "; Value: " + str(self.value)


class PQ:
    def __init__(self):
        self.priority_queue = []

    def add(self, priority, value):
        e = Entry(priority, value)
        if (len(self.priority_queue) < 1):
            self.priority_queue.insert(0, e)
            return
        for i in range(len(self.priority_queue)):
            if self.priority_queue[i].get_priority() > priority:
                self.priority_queue.insert(i, e)
                return
        self.priority_queue.append(e)
        return

    def remove_min(self):
        if len(self.priority_queue) < 1:
            return
        min_priority = self.priority_queue[0]
        del self.priority_queue[0]
        return str(min_priority)

    def set_priority(self, value, priority):
        if len(self.priority_queue) < 1:
            return
        for i in range(len(self.priority_queue)):
            if str(value) == str(self.priority_queue[i].get_value()):
                temp = self.priority_queue[i]
                del self.priority_queue[i]
                self.add(priority, value)
                continue
        return

    def size(self):
        return len(self.priority_queue)

    def print_out(self):
        for e in self.priority_queue:
            print(str(e))
        return


if __name__ == "__main__":
    sys.exit(main())
