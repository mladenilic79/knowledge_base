class Book < ApplicationRecord

  validates_presence_of :book_name, :book_number

  # many to many relationship
  belongs_to :theme
  belongs_to :author

end
