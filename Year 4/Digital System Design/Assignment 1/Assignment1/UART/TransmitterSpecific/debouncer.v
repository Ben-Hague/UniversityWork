module debouncer(switch, Send, clk, reset_n);
	// define clock and reset input
	input clk, reset_n;
	//Define Switch input
	input switch;
	
	//Define Output
	output reg Send;
	
	//define state parameters
	
	parameter [1:0] Hold = 2'b00, Pulse = 2'b01, Wait = 2'b10;
	
	//define current and next states
	reg [1:0] pstate = Hold, nstate;
	
	//Define Synchronous state movement
	always @(posedge clk, negedge reset_n)
		if (reset_n == 0)
			pstate = Hold;
		else
			pstate = nstate;
	
	//State Machine
	always @(clk,switch)
	begin
		// Set Defaults to prevent latches
		nstate = pstate; 
		Send = 0;
		case(pstate)
		Hold:
			if (switch)
			begin
				nstate = Pulse;
			end
		Pulse:
			begin
				nstate = Wait;
				Send = 1;
			end
		Wait:
			if(!switch)
				nstate = Hold;
		endcase
	end
endmodule