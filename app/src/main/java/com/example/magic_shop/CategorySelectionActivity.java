package com.example.magic_shop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class CategorySelectionActivity extends AppCompatActivity {

    private ImageView imageView;

    private int selectedCategory = 0;

    CategorySelection categorySelection = CategorySelection.getInstance();

    private final int[] categoryButtonIds = {
            R.id.btn_top_id,
            R.id.btn_outer_id,
            R.id.btn_pants_id,
            R.id.btn_skirt_one_piece_id,
            R.id.btn_shoes_id,
            R.id.btn_bag_id
    };

    private final int[] detailedButtonIds = {
            R.id.btn_top1_id,
            R.id.btn_top2_id,
            R.id.btn_top3_id,
            R.id.btn_top4_id,
            R.id.btn_top5_id,
            R.id.btn_top6_id,
            R.id.btn_top7_id,
            R.id.btn_top8_id,
            R.id.btn_top9_id,
            R.id.btn_top10_id,
            R.id.btn_top11_id,
            R.id.btn_top12_id
    };

    private final int[] categoryImageSources = {
            R.drawable.category_top,
            R.drawable.category_outer,
            R.drawable.category_pants,
            R.drawable.category_skirt_one_piece,
            R.drawable.category_shoes,
            R.drawable.category_bag
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_selection);


        for (int buttonId : detailedButtonIds) {
            findViewById(buttonId).setOnClickListener(new DetailedCategoryButtonClickListener());
        }

        for (int buttonId : categoryButtonIds) {
            findViewById(buttonId).setOnClickListener(new CategoryButtonClickListener());
        }


    }


    private class CategoryButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            Button btn = findViewById(view.getId());
            btn.setBackgroundColor(getResources().getColor(android.R.color.white));
            btn.setTextColor(getResources().getColor(R.color.category_main_color));

            changeButtonColorsWithoutSelected(view.getId());

            for (int i=0; i<6; i++) {
                if (view.getId() == categoryButtonIds[i]) {
                    imageView = findViewById(R.id.category_top_id);
                    imageView.setImageResource(categoryImageSources[i]);
                    categorySelection.changeCategory(i);
                    break;
                }
            }

        }
    }

    private class DetailedCategoryButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            int clickedId = view.getId();

            for(int i=0; i<12; i++) {
                if (clickedId == detailedButtonIds[i]) {
                    categorySelection.setSelectedDetailedCategory(i);
                }
            }

            Intent intent = new Intent(CategorySelectionActivity.this, CategoryProductListActivity.class);
            startActivity(intent); // Intent를 사용하여 SecondActivity 시작

        }
    }

    // 추가 메서드: 버튼의 초기 모양을 설정하는 함수
    private void resetButtonAppearance(int buttonId) {
        Button button = findViewById(buttonId);
        button.setBackgroundColor(getResources().getColor(R.color.category_background_color));
        button.setTextColor(getResources().getColor(R.color.category_text_color));
    }

    private void changeButtonColorsWithoutSelected(int clickedButtonId) {

        for (int buttonId : categoryButtonIds) {
            if (buttonId != clickedButtonId) resetButtonAppearance(buttonId);

        }
    }



}
