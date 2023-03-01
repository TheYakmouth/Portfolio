const cryptid = {
	name: "Bigfoot",
	height: 9,
	attack(){
		return this.name + " the generic cryptid, " + this.height + " feet tall, attacks with its special weapon!";
	}
}

function Cryptid(name, height){
	this.name = name;
	this.height = height;
}

const bigfoot = {
	__proto__:cryptid,
	shoeSize: 17,
	attack(){
		return this.name + " the bigfoot, " + this.height + " feet tall, stomps you!";
	}
}

function Bigfoot(name, height, shoeSize){
	this.name = name;
	this.height = height;
	this.shoeSize = shoeSize;
}

Bigfoot.prototype = bigfoot;
Bigfoot.prototype.constructor = Bigfoot;
const b = new Bigfoot("Barry", 9, 17);
console.log(b.attack());

Cryptid.prototype = cryptid;
Cryptid.constructor = Cryptid;
const c = new Cryptid("Cryptid", 4.5);
console.log(c.attack());
