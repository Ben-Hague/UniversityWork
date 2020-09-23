module irdaTxD(Load,Shift,Count,TxD,clk,reset_n,IrDA,CountReset);
	// define inputs for clock and reset
		input clk,reset_n;
		// define control inputs
		input Load, Shift,Count,TxD;
		// define control outputs
		output reg IrDA, CountReset;
		
		// set states as parameters
		parameter[1:0] Delay = 2'b11, Send = 2'b10, Hold = 2'b00;
		
		// define default states for current and next
		reg [1:0]pstate = Hold, nstate;
		
		// Synchronous state movement, asynchronous reset
		always@(posedge clk, negedge reset_n)
			if (reset_n==0)
				pstate = Hold;
			else 
				pstate = nstate;
		// always block dictated state machine
		always@(Load, Shift,Count, pstate, TxD)
		begin
		// set defaults to prevent latches
		IrDA = 0;
		CountReset = 0;
		nstate = pstate;
		case (pstate)
		Delay: // delay ensures that the command is sent in the middle of the message
		begin
			CountReset = 1;
			if (Count)
			begin				
				nstate = Send;
			end
		end
		Send: // send sends the command for a set length period
		begin
			CountReset = 1;
			IrDA = !TxD;
			if (Count)
				nstate = Hold;
		end
		Hold: // Wait for the remander of the bit length then delay again
			if (Shift || Load)
			begin
				nstate = Delay;
			end 
		endcase
		end
	endmodule