package com.gildedrose;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

// the main method for updating both the quality and the sellIn for each product
	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			switch (items[i].name) {
			case "Aged Brie":
				UpdateAgedBrie(i);
				break;
			case "Backstage passes to a TAFKAL80ETC concert":
				UpdateBackstage(i);
				break;

			case "Sulfuras, Hand of Ragnaros":
				//nothing to do because they always stable no update
				break;

			default:
				UpdateOther(i);
				break;

			}
		}

	}

	// below you will find the method for each product

	public void UpdateAgedBrie(int i) {
		if (items[i].quality > 49) {
			items[i].sellIn--;
		} else {
			items[i].quality++;
			items[i].sellIn--;
		}

	}

	public void UpdateBackstage(int i) {

		if (items[i].sellIn > 0) {

			if (items[i].sellIn < 6 && items[i].quality < 48) {
				items[i].quality += 3;
				items[i].sellIn--;
			} else if (items[i].sellIn < 11 && items[i].quality < 49) {
				items[i].quality += 2;
				items[i].sellIn--;
			} else if (items[i].quality < 50) {
				items[i].quality++;
				items[i].sellIn--;

			} else {
				items[i].sellIn--;
			}
		} 
		//if the backstage expire the quality automatically zero
		else {
			items[i].quality = 0;
			items[i].sellIn--;
		}

	}

	

	public void UpdateOther(int i) {
		if (items[i].quality == 0) {
			items[i].sellIn--;
		} else {
			items[i].quality--;
			items[i].sellIn--;
		}

	}
}
