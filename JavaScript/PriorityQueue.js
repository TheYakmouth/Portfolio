class PriorityQueue{
	constructor(pqueue){
		this.pqueue = [];
	}
	add(priority, value){
		let e = new Entry(priority, value);
		if ((this.pqueue.length) < 1){
			this.pqueue.push(e);
			return;
		}
		for (let i = 0; i < this.pqueue.length; i++){
			if (this.pqueue[i].getPriority() > priority){
				this.pqueue.splice(i, 0, e);
				return;
			}
		}
		this.pqueue.push(e);
		return;
	}
	removeMin(){
		if (this.pqueue.length < 1){
			return;
		}
		let min = this.pqueue.shift();
		return "Priority: "+min.getPriority()+"; Value: "+min.getValue();
		
	}
	setEntryPriority(value, priority){
		if (this.pqueue.length < 1){
			return;
		}
		for (let i = 0; i < this.pqueue.length; i++){
			if (value === this.pqueue[i].getValue()){
				this.pqueue.pop();
				this.add(priority, value);
				//this.pqueue[i].setPriority(priority);
				return;
			}
		}
		return;
	}
	size(){
		return this.pqueue.length;
	}
}

class Entry{
	constructor(priority, value){
		this.priority = priority;
		this.value = value;
	}
	getPriority(){
		return this.priority;
	}
	setPriority(priority){
		this.priority = priority;
	}
	getValue(){
		return this.value;
	}
	setValue(value){
		this.value = value;
	}
}

let pq = new PriorityQueue();
console.log("Size of Empty Priority Queue: "+pq.size());
pq.add(2, "Eat");
pq.add(0, "Study");
pq.add(3, "Sleep");
pq.add(1, "Maintain Personal Relationships");
pq.add(4, "Practice Good Personal Hygiene");
console.log("Size of Priority Queue: "+pq.size());

pq.setEntryPriority("Practice Good Personal Hygiene", 2);
pq.setEntryPriority("Eat", 4);

while (pq.size() > 0){
	console.log(pq.removeMin());
} 
console.log("Size of empty Priority Queue: "+pq.size());

