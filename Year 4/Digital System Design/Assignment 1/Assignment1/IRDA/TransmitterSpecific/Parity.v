module Parity(Data, Dataout);
	// No Clock and Reset in this block as it is purely combinational logic.
	// Input for Data (width 7)
	input [6:0] Data;
	// Output for Data (width 11) with start stop and parity added
	output reg [10:0] Dataout;
	// ParityBit must be reg to write data to it 
	// Here to help readability
	reg ParityBit;
	
	// Start and Stop Bits as registers so they can be updated in the BDF
	parameter startBit = 1'b0, stopBit = 2'b11;
	
	// Execute block on change of data
	always @ (Data)
		begin
			// Even Parity declaration
			ParityBit = !(^Data);
			// Concoct the data output
			Dataout = {stopBit, ParityBit, Data, startBit};
		end
endmodule
