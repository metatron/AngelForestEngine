package jp.arrow.angelforest.engine.param;

import java.util.ArrayList;

public class TextureParameters {
	private ArrayList<Integer> nomotiontextureIds = new ArrayList<Integer>();
	private ArrayList<Integer> downmotiontextureIds = new ArrayList<Integer>();
	private ArrayList<Integer> upmotiontextureIds = new ArrayList<Integer>();
	private ArrayList<Integer> leftmotiontextureIds = new ArrayList<Integer>();
	private ArrayList<Integer> rightmotiontextureIds = new ArrayList<Integer>();
	
	public TextureParameters(ArrayList<Integer> nomotiontextureIds,
			ArrayList<Integer> downmotiontextureIds,
			ArrayList<Integer> upmotiontextureIds,
			ArrayList<Integer> leftmotiontextureIds,
			ArrayList<Integer> rightmotiontextureIds) {
		super();
		this.nomotiontextureIds = nomotiontextureIds;
		this.downmotiontextureIds = downmotiontextureIds;
		this.upmotiontextureIds = upmotiontextureIds;
		this.leftmotiontextureIds = leftmotiontextureIds;
		this.rightmotiontextureIds = rightmotiontextureIds;
	}
	
	public ArrayList<Integer> getNomotiontextureIds() {
		return nomotiontextureIds;
	}
	public ArrayList<Integer> getDownmotiontextureIds() {
		return downmotiontextureIds;
	}
	public ArrayList<Integer> getUpmotiontextureIds() {
		return upmotiontextureIds;
	}
	public ArrayList<Integer> getLeftmotiontextureIds() {
		return leftmotiontextureIds;
	}
	public ArrayList<Integer> getRightmotiontextureIds() {
		return rightmotiontextureIds;
	} 

}
