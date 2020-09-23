module Splitter(Data, MostSig, LeastSig);
	input [6:0] Data;
	output [3:0] MostSig, LeastSig;
	assign MostSig = {1'b0,Data[6:4]};
	assign LeastSig = Data[3:0];
endmodule