class Cryptid{
	constructor(name, height){
	this.name = name;
	this.height = height;
	} 
	attack(){
		return this.name + " the generic cryptid, " + this.height + " feet tall, attacks with its special weapon!";
	}
}

class Bigfoot extends Cryptid{
	constructor(name, height, shoeSize){
		super(name, height);
	this.shoeSize = shoeSize;
	} 
	attack(){
		return this.name + " the bigfoot, " + this.height + " feet tall, stomps you!";
	}
}

let b = new Bigfoot("Barry", 9, 17);
console.log(b.attack());
