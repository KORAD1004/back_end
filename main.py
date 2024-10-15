from typing import Union
from fastapi import FastAPI
from pydantic import BaseModel
from sklearn.linear_model import LinearRegression
import pandas as pd
import numpy as np

app = FastAPI()

class Item(BaseModel):
    name: str
    description: Union[str, None] = None
    price: float

@app.get("/api/predict")

async def read_root():
    data = {
    'Year': [2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023],
    'AccumulatedAmount': [8843, 4954, 5825, 3682, 16, 4014, 2456, 1754, 3340]
    }

    yearly_data = pd.DataFrame(data)
    yearly_data['CumulativeAmount'] = yearly_data['AccumulatedAmount'].cumsum()

    # 선형 회귀 모델 생성
    model = LinearRegression()

    # 학습 데이터 준비 (연도와 누적 인수량)
    X_cumulative = yearly_data[['Year']]  # 연도
    y_cumulative = yearly_data['CumulativeAmount']  # 누적 인수량

    # 모델 학습
    model.fit(X_cumulative, y_cumulative)

    # 예측을 위한 연도 데이터 생성 (10년, 20년, 30년 뒤)
    future_years = np.array([[2023 + 10], [2023 + 20], [2023 + 30]])

    # 누적 인수량을 기준으로 예측 수행
    cumulative_predictions = model.predict(future_years)

    # 예측 결과 출력
    for year, amount in zip(future_years, cumulative_predictions):
        print(f"Year: {year[0]}, Predicted Cumulative Amount: {amount:.2f} 개")


    number = list([0,0,0])
    for i in range(len(number)):
        predict = int(cumulative_predictions[i])*100
        predict = predict/800000
        predict=round(predict,1)
        number[i]=predict
    
    return number
