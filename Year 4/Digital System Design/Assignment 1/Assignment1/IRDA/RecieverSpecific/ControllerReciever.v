module ControllerReciever(clk,reset_n,Baud,HalfBaud,B_Done,RxD, Shift,ResetBaud,ResetHalfBaud,ResetBitCount );
// clk and reset input(Active high)
input clk, reset_n;
// Event inputs
input Baud, HalfBaud, B_Done, RxD;
// Control signals outputs
output reg Shift,ResetBaud,ResetHalfBaud,ResetBitCount;
// Define States as parameters
parameter[1:0] Wait = 2'b00, Half =2'b01, Receive = 2'b11;
//reg for current and next state
reg[1:0] pstate, nstate;

// Recieving edge detection
reg Recieving;
always @(negedge RxD, posedge clk)
	if (RxD == 0) 
		Recieving = 1;
	else Recieving = 0;

// synchronous block for state movement and asynchronous reset
always @ (posedge clk, negedge reset_n)
	if (reset_n == 0)
		pstate <= Wait;
	else pstate <= nstate;


always @(Shift, Baud, HalfBaud,pstate, B_Done, Recieving)
begin 
	// Set defaults to prevent latch Synthasis
	// Reset High not low
	ResetBaud = 1;
	ResetHalfBaud = 1;
	ResetBitCount = 1;
	Shift = 0;
	nstate = pstate;
	// State Machine
	case (pstate)
	Wait: // Detect the start of the signal
			// move to state Half
			// reset half baud counter
	begin 
		if (Recieving)
			begin
				ResetHalfBaud = 0;
				nstate = Half;
			end
	end
	Half: // wait until a half baud has appeared
	begin 
		if (HalfBaud)
		begin
			ResetBaud = 0;
			ResetBitCount = 0;
			nstate = Receive;
			Shift = 1;
		end
	end
	Receive: // pass the shift command through 
				// but only until the end of the signal
	begin
		if (Baud)
		begin 
			Shift = 1;
		end
		if (B_Done)
		begin
			nstate = Wait;
		end
	end
	endcase
end
endmodule