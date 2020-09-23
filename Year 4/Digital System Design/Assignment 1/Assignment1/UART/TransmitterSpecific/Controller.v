module Controller(clk, reset_n,Send, Baud, B_Done,ResetBaud, ResetBit,ResetShift, Load,Shift);
	//Define inputs for clk and reset
	input clk,reset_n;
	// inputs for send baud and bdone
	input Send,Baud,B_Done;
	//reset signal outputs
	output reg ResetBaud,ResetBit,ResetShift;
	//control signal outputs;
	output reg Load,Shift;

	//parameters for the states
	parameter hold = 1'b0, sending = 1'b1; 
	// define the current and next state
	reg pstate,nstate;
	
	// synchronising block for reset and state transistion
   always @ (posedge clk, negedge reset_n)
	if (reset_n == 0)
		pstate <= hold;
	else pstate <= nstate;
	
	always @ (Send, Baud, B_Done, pstate)
		begin// Set Defaults (Reset Active High)
		ResetBaud = 1;
		ResetBit = 1;
		ResetShift = 1;
		// Set Defaults for control signals (Shift Reg)
		Load = 0;
		Shift = 0;
		// Set antiLatch State assignment
		nstate = pstate;
		// State Machine
		case (pstate)
		hold: 
		begin
			if (Send) // if send is high reset the baud and bit then move to sending state
				begin
					Load = 1;
					nstate = sending;
					ResetBaud = 0;
					ResetBit = 0;
				end
		end 
		sending: //Sending State
		begin
			if (Baud) 	//on Baud Shift and reset the Baud Count
			begin
				Shift = 1;
			end
			if (B_Done)	//on send complete (B_Done) Reset the shifter and move to hold state 
			begin
				nstate = hold;
				ResetShift = 0;
			end
				
		end
		endcase
	end
endmodule
